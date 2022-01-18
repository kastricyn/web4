import {Component, OnInit} from '@angular/core';
import {DrawContextService} from "../../service/draw-context.service";

@Component({
  selector: 'app-check-area',
  templateUrl: './check-area.component.html',
  styleUrls: ['./check-area.component.scss']
})
export class CheckAreaComponent implements OnInit {
  private drawer: DrawContextService | undefined

  constructor() {
  }

  ngOnInit(): void {
    this.drawer = new DrawContextService(<HTMLCanvasElement>document.getElementById("areaCanvas"))
    this.drawer.draw()
  }

}
