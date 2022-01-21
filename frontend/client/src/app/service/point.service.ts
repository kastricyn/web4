import {Injectable} from '@angular/core';
import {Point} from "../model/point";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PointService {
  private readonly host: string = "http://localhost:8080/";
  private readonly url: string = "api/points";

  points: Point[] = Array()

  constructor(private http: HttpClient) {
  }

  getAllPoints(): Point[] {
    this.http.get(this.host + this.url).subscribe((result) => {
      // @ts-ignore
      this.points = result;

    });
    return this.points;
  }

  checkPointInArea(point: Point) {

    // @ts-ignore

    console.log(point)
    // @ts-ignore
    this.http.post(this.host + this.url, point, {      headers: new HttpHeaders().set('Authorization', localStorage.getItem("auth_token")),
    }).subscribe(resp => console.log("Запрос отправлен"))
  }

}
