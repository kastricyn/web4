import { Injectable } from '@angular/core';
import {Point} from "../model/point";

@Injectable({
  providedIn: 'root'
})
export class PointService {

  constructor() { }
  checkPointInArea  = (point : Point) :boolean => Math.random()>0.5


  getAllPoints(): Point[] {
    var target :Point []  = [
      {x: 1, y: 1, r: 1, result: true},
      {x: 1, y: 0, r: 0, result: false},
    ];
    return target;
  }
}
