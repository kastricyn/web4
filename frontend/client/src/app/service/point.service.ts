import { Injectable } from '@angular/core';
import {Point} from "../model/point";

@Injectable({
  providedIn: 'root'
})
export class PointService {

  constructor() { }
  checkPointInArea  = (point : Point) :boolean => Math.random()>0.5
}
