import {Injectable} from '@angular/core';
import {Point} from "../model/point";
import {PointService} from "./point.service";

@Injectable({
  providedIn: 'root'
})
export class DrawContextService {
  get points(): Point[] {
    return this._points;
  }

  set points(value: Point[]) {
    this._points = value;
  }

  get r(): number {
    return this._r;
  }

  set r(value: number) {
    this._r = value;
  }
  readonly ctx: CanvasRenderingContext2D
  readonly width: number
  readonly height: number
  private _points!: Point[];
  private _r: number = 2

  constructor(readonly canvas: HTMLCanvasElement, private pointService: PointService) {
    const tmp = canvas.getContext("2d")
    if (tmp == null)
      throw new Error("Canvas.getContext('2d')==null")
    this.ctx = tmp
    this.width = canvas.width
    this.height = canvas.height
    this.points = pointService.points
    this.r = pointService.currentPoint.r
  }

  drawAxes(canvas: HTMLCanvasElement = this.canvas, color: string = "black"): void {
    const h = canvas.height;
    const w = canvas.width;
    const c = canvas.getContext('2d');
    if (c == null)
      throw new DOMException();
    c.save();

    c.strokeStyle = color;
    c.fillStyle = color;

    c.setTransform(1, 0, 0, 1, 0, 0); //устанавливаем значение по умолчанию
    //рисуем вертикальную ось
    c.beginPath();
    c.moveTo(0.5 * w, h - 10);
    c.lineTo(0.5 * w, 10);
    c.lineTo(0.5 * w - 5, 15);
    c.moveTo(0.5 * w + 5, 15);
    c.lineTo(0.5 * w, 10);
    c.closePath();
    c.stroke();
    //подпись к вертикальной оси
    c.strokeText("y", 0.5 * w + 5, 15);

    //рисуем горизонтальную ось
    c.beginPath();
    c.moveTo(10, 0.5 * h);
    c.lineTo(w - 10, 0.5 * h);
    c.lineTo(w - 15, 0.5 * h - 5);
    c.moveTo(w - 15, 0.5 * h + 5);
    c.lineTo(w - 10, 0.5 * h);
    c.closePath();
    c.stroke();
    //подпись к горизонтальной оси
    c.strokeText("x", w - 15, 0.5 * h + 15);

    //отсечки на вертикальной оси
    c.beginPath();
    c.moveTo(0.5 * w - 3, 10 + 0.8 * (h - 20));
    c.lineTo(0.5 * w + 3, 10 + 0.8 * (h - 20));
    c.moveTo(0.5 * w - 3, 10 + 0.7 * (h - 20));
    c.lineTo(0.5 * w + 3, 10 + 0.7 * (h - 20));
    c.moveTo(0.5 * w - 3, 10 + 0.6 * (h - 20));
    c.lineTo(0.5 * w + 3, 10 + 0.6 * (h - 20));
    c.moveTo(0.5 * w - 3, 10 + 0.4 * (h - 20));
    c.lineTo(0.5 * w + 3, 10 + 0.4 * (h - 20));
    c.moveTo(0.5 * w - 3, 10 + 0.3 * (h - 20));
    c.lineTo(0.5 * w + 3, 10 + 0.3 * (h - 20));
    c.moveTo(0.5 * w - 3, 10 + 0.2 * (h - 20));
    c.lineTo(0.5 * w + 3, 10 + 0.2 * (h - 20));
    c.closePath();
    c.stroke();
    //подпись на отсечках вертикальной оси
    c.fillText("3", 0.5 * w + 5, 10 + 0.2 * (h - 20) + 5);
    c.fillText("2", 0.5 * w + 5, 10 + 0.3 * (h - 20) + 5);
    c.fillText("1", 0.5 * w + 5, 10 + 0.4 * (h - 20) + 5);
    c.fillText("-1", 0.5 * w + 5, 10 + 0.6 * (h - 20) + 5);
    c.fillText("-2", 0.5 * w + 5, 10 + 0.7 * (h - 20) + 5);
    c.fillText("-3", 0.5 * w + 5, 10 + 0.8 * (h - 20) + 5);

    //отсечки на горизонтальной оси
    c.beginPath();
    c.moveTo(10 + 0.8 * (w - 20), 0.5 * h - 3);
    c.lineTo(10 + 0.8 * (w - 20), 0.5 * h + 3);
    c.moveTo(10 + 0.6 * (w - 20), 0.5 * h - 3);
    c.lineTo(10 + 0.6 * (w - 20), 0.5 * h + 3);
    c.moveTo(10 + 0.7 * (w - 20), 0.5 * h - 3);
    c.lineTo(10 + 0.7 * (w - 20), 0.5 * h + 3);
    c.moveTo(10 + 0.4 * (w - 20), 0.5 * h - 3);
    c.lineTo(10 + 0.4 * (w - 20), 0.5 * h + 3);
    c.moveTo(10 + 0.3 * (w - 20), 0.5 * h - 3);
    c.lineTo(10 + 0.3 * (w - 20), 0.5 * h + 3);
    c.moveTo(10 + 0.2 * (w - 20), 0.5 * h - 3);
    c.lineTo(10 + 0.2 * (w - 20), 0.5 * h + 3);
    c.closePath();
    c.stroke();
    //подписи на отсечках горизонтальной оси
    c.fillText("3", 10 + 0.8 * (w - 20) - 4, 0.5 * h + 15);
    c.fillText("2", 10 + 0.7 * (w - 20) - 12, 0.5 * h + 15);
    c.fillText("1", 10 + 0.6 * (w - 20) - 12, 0.5 * h + 15);
    c.fillText("-1", 10 + 0.4 * (w - 20) - 18, 0.5 * h + 15);
    c.fillText("-2", 10 + 0.3 * (w - 20) - 18, 0.5 * h + 15);
    c.fillText("-3", 10 + 0.2 * (w - 20) - 8, 0.5 * h + 15);

    c.restore();
  }

  toMathAxes(ctx: CanvasRenderingContext2D = this.ctx, width: number = ctx.canvas.width, height: number = ctx.canvas.height): void {
    ctx.setTransform(1, 0, 0, 1, 0, 0); // устанавливаем значения по умолчанию
    ctx.translate(width / 2, height / 2);
    ctx.scale(1, -1);
  }

  drawPoint(x: number, y: number, r: number, color: string = "yellow", ctx: CanvasRenderingContext2D = this.ctx, w: number = ctx.canvas.width, h: number = ctx.canvas.height): void {
    const corTransform = new CoordinateTransform(r, w, h)
    const {x: left, y: top} = corTransform.getPixelsInJSAxesFromUserCoordinate(x, y);
    const [dx, dy] = [5, 5];
    ctx.fillStyle = color;
    ctx.fillRect(left - dx / 2, top - dy / 2, dx, dy);
  }

  drawAllPoint(points: Point[], ctx: CanvasRenderingContext2D = this.ctx, width: number = ctx.canvas.width, height: number = ctx.canvas.height): void {
    for (const point of points) {
      let {x, y, r, result} = point;
      this.drawPoint(
        x, y, r,
        result ? "rgba(0, 255, 0, 0.6)" : "rgba(255, 0, 0, 0.6)",
        ctx, width, height,
      );
    }
  }

  draw(points: Point[] = this._points, ctx: CanvasRenderingContext2D = this.ctx, w: number = ctx.canvas.width, h: number = ctx.canvas.height, r: number = this._r): void {
    ctx.font = "14px Verdana";
    ctx.fillStyle = "white";
    ctx.fillRect(0, 0, w, h);
    ctx.fillStyle = "#359aff";
    this.drawArea(ctx, w, h, r);
    this.drawAxes(ctx.canvas, "black");
    this.drawAllPoint(points, ctx, w, h);
  }

  drawArea(ctx: CanvasRenderingContext2D = this.ctx, w: number = ctx.canvas.width, h: number = ctx.canvas.height, r: number = 2): void {
    //Радиусы большого эллипса
    ctx.fillStyle = "#359aff";
    ctx.save();
    this.toMathAxes(ctx, w, h);
    const corTransform = new CoordinateTransform(r, w, h);

    let {x: rPixel} = corTransform.getPixelsInMathAxesFromUserCoordinate(r, r / 2)

    // console.log(rPixel, rPixel / 2);
    ctx.fillRect(0, -rPixel / 2, rPixel, rPixel / 2);
    //рисуем треугольник
    ctx.beginPath();
    ctx.moveTo(0, 0);
    ctx.lineTo(-rPixel, 0);
    ctx.lineTo(0, rPixel / 2);
    ctx.closePath();
    ctx.fill();

    ctx.beginPath();
    ctx.moveTo(0, 0);
    if (rPixel >= 0)
      ctx.arc(0, 0, rPixel, Math.PI / 2, 0, true);
    else
      ctx.arc(0, 0, -rPixel, -Math.PI / 2, -Math.PI, true);
    ctx.closePath();
    ctx.fill();

    ctx.restore();

  }
}

// window.onload = setTimeout(draw, 50);
// setInterval(draw, 250);

class CoordinateTransform {
  private _r: number
  private _w: number
  private _h: number

  constructor(r: number, w: number, h: number) {
    this._r = r;
    this._w = w;
    this._h = h;
  }

  /**
   * Получает на вход x, y в математических осях возвращает координаты для отрисовки в пикселях, считая что центр координат находится в центре канваса, и оси направлены в привычном математическом виде
   * @param x
   * @param y
   * @returns {{top: number, left: number}}
   */
  getPixelsInMathAxesFromUserCoordinate(x: number, y: number): { x: number, y: number } {
    return {
      x: x * (0.2 * (this._w / 2 - 10)),
      y: y * (0.2 * (this._h / 2 - 10))
    };
  }

  /**
   * Получает на вход x, y координаты возвращает пиксели, считая что центр координат находится и направлены по умолчанию для js
   * @param x
   * @param y
   * @returns {{x: number, y: number}}
   */
  getPixelsInJSAxesFromUserCoordinate(x: number, y: number): { x: number, y: number } {
    ({x, y} = this.getPixelsInMathAxesFromUserCoordinate(x, y));
    x += this._w / 2;
    y = -(y - this._h / 2);
    return {x, y};
  }

  /**
   * Получает на вход пиксели в математических осях, возвращает x, y в формате формы пользователя
   * @param x
   * @param y
   * @returns {{x: number, y: number}}
   */
  getUserCoordinateFromPixelsInMathAxes(x: number, y: number): { x: number, y: number } {
    return {
      x: x / (0.2 * (this._w / 2 - 10)),
      y: y / (0.2 * (this._h / 2 - 10))
    }
  }

  /**
   * Получает на вход пиксели в осях по умолчанию js, возвращает x, y в формате формы пользователя
   * @param x
   * @param y
   * @returns {{x: number, y: number}}
   */
  getUserCoordinateFromPixelsInJSAxes(x: number, y: number): { x: number, y: number } {
    x -= this._w / 2;
    y = -(y - this._h / 2);
    return this.getUserCoordinateFromPixelsInMathAxes(x, y);
  }


  get r(): number {
    return this._r;
  }

  set r(value: number) {
    this._r = value;
  }

  get w(): number {
    return this._w;
  }

  set w(value: number) {
    this._w = value;
  }

  get h(): number {
    return this._h;
  }

  set h(value: number) {
    this._h = value;
  }
}
