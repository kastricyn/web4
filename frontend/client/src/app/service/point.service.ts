import {Injectable} from '@angular/core';
import {Point} from "../model/point";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PointService {
  private readonly host: string = "http://localhost:8080/";
  private readonly url: string = "api/points";
  private _currentPoint: Point = new Point(0, 0, 2)

  points: Point[] = Array()

  constructor(private http: HttpClient) {
    this.getAllPoints()
  }

  getAllPoints(): Point[] {
    this.http.get(this.host + this.url, {
      // @ts-ignore
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem("auth_token")),
    }).subscribe((result) => {
      // @ts-ignore
      this.points = result;
    });
    return this.points;
  }

  checkPointInArea(point: Point) {

    this.http.post(this.host + this.url, point, {
      // @ts-ignore
      headers: new HttpHeaders().set('Authorization', "Bearer " + localStorage.getItem("auth_token")),
    }).subscribe();
  }

  get currentPoint(): Point {
    return this._currentPoint;
  }

  set currentPoint(value: Point) {
    this._currentPoint = value;
  }
}
