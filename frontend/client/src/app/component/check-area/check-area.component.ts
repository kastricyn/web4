import {Component, OnInit} from '@angular/core';
import {DrawContextService} from "../../service/draw-context.service";
import {PointService} from "../../service/point.service";

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
      console.log("Update r = " + this.drawer?.r)
      // @ts-ignore
      this.drawer.draw()
    }, 250)

  }

  checkPoint() {

  }

}
