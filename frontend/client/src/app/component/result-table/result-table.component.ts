import { Component, OnInit } from '@angular/core';
import {Point} from "../../model/point";

const points : Point[] = [
  {x:1, y:1, r:1, result:true},
  {x:1, y:0, r:0, result:false},
]

@Component({
  selector: 'app-result-table',
  templateUrl: './result-table.component.html',
  styleUrls: ['./result-table.component.scss']
})
export class ResultTableComponent implements OnInit {
  displayedColumns: string[] = ['x', 'y', 'r', 'result'];
  dataSource = points;
  constructor() { }

  ngOnInit(): void {
  }

}
