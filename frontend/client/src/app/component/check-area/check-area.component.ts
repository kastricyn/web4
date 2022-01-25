import {Component, OnInit} from '@angular/core';
import {CoordinateTransform, DrawContextService} from "../../service/draw-context.service";
import {PointService} from "../../service/point.service";
import {Point} from "../../model/point";

@Component({
  selector: 'app-check-area',
  templateUrl: './check-area.component.html',
  styleUrls: ['./check-area.component.scss']
})
export class CheckAreaComponent implements OnInit {
  private drawer: DrawContextService | undefined

  constructor(private pointService: PointService) {
  }

  ngOnInit(): void {
    this.drawer = new DrawContextService(<HTMLCanvasElement>document.getElementById("areaCanvas"), this.pointService)
    setInterval(() => {
      // @ts-ignore
      this.drawer?.r = this.pointService.currentPoint.r
      // @ts-ignore
      this.drawer?.points = this.pointService.points
      // @ts-ignore
      this.drawer.draw()
    }, 250)

  }

  // @ts-ignore
  checkPoint(event) {
    const r = this.pointService.currentPoint.r
    const prevX = event.offsetX;
    const prevY = event.offsetY;
    // @ts-ignore
    const {x, y} = new CoordinateTransform(r, this.drawer?.width, this.drawer?.height).getUserCoordinateFromPixelsInJSAxes(prevX, prevY);
    if(Math.abs(x)<=5 && y>=-3 &&y<=5)
      this.pointService.checkPointInArea(new Point(x, y, r));
  }

}
