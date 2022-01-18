import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {PointService} from "../../service/point.service";
import {Point} from "../../model/point";

@Component({
  selector: 'app-check-area-form',
  templateUrl: './check-area-form.component.html',
  styleUrls: ['./check-area-form.component.scss']
})
export class CheckAreaFormComponent implements OnInit {
  areaForm: FormGroup;
  private _canCheck: boolean = true

  constructor(private checkPointService: PointService) {
    this.areaForm = new FormGroup({
      xControl: new FormControl(null, [Validators.required, Validators.pattern("^[+-]?[0-9]*[.]?[0-9]+$"), Validators.min(-5), Validators.max(5)]),
      yControl: new FormControl(null, [Validators.required, Validators.pattern("^[+-]?[0-9]*[.]?[0-9]+$"), Validators.min(-3), Validators.max(5)]),
      rControl: new FormControl(null, [Validators.required, Validators.pattern("^[+-]?[0-9]*[.]?[0-9]+$"), Validators.min(-5), Validators.max(5)]),
    })
  }

  check = (): boolean => this.checkPointService.checkPointInArea(new Point(
    this.areaForm.get("xControl")?.value,
    this.areaForm.get("yControl")?.value,
    this.areaForm.get("rControl")?.value
  ))

  ngOnInit(): void {
    this.areaForm.statusChanges.subscribe((status) => {this.canCheck = "VALID"===status});
  }

  get canCheck(): boolean {
    return this._canCheck;
  }

  private set canCheck(value: boolean) {
    this._canCheck = value;
  }
}
