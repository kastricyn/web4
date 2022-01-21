import {Component, OnInit} from '@angular/core';
import {Point} from "../../model/point";
import {PointService} from "../../service/point.service";


@Component({
  selector: 'app-result-table',
  templateUrl: './result-table.component.html',
  styleUrls: ['./result-table.component.scss']
})
export class ResultTableComponent implements OnInit {
  displayedColumns: string[] = ['x', 'y', 'r', 'result'];
  dataSource: Point[];

  constructor(private pointService: PointService) {
    this.dataSource = pointService.points;
  }

  ngOnInit(): void {
    setInterval(() => this.dataSource = this.pointService.getAllPoints(), 250)
  }


}
