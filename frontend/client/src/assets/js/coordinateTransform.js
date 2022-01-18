class CoordinateTransform {
  r;
  w;
  h;

  constructor(r, w, h) {
    this.r = r;
    this.w = w;
    this.h = h;
  }

  /**
   * Получает на вход x, y в математических осях возвращает координаты для отрисовки в пикселях, считая что центр координат находится в центре канваса, и оси направлены в привычном математическом виде
   * @param x
   * @param y
   * @returns {{top: number, left: number}}
   */
  getTopLeftInNormalAxes(x, y) {
    return {
      left: x * (0.2 * (this.w / 2 - 10) ),
      top: y * (0.2 * (this.h / 2 - 10) )
    };
  }

  /**
   * Получает на вход x, y координаты возвращает пиксели, считая что центр координат находится и направлены по умолчанию для js
   * @param x
   * @param y
   * @returns {{top: number, left: number}}
   */
  getTopLeftInStandardAxes(x, y) {
    ({left: x, top: y} = this.getTopLeftInNormalAxes(x, y));
    x += this.w / 2;
    y = -(y - this.h / 2);
    return {left: x, top: y};
  }

  /**
   * Получает на вход пиксели в математических осях, возвращает x, y в формате формы пользователя
   * @param x
   * @param y
   * @returns {{x: number, y: number}}
   */
  getXYFromNormalAxes(x, y) {
    return {
      x: x / (0.2 * (this.w / 2 - 10) ),
      y: y / (0.2 * (this.h / 2 - 10) )
    }
  }

  /**
   * Получает на вход пиксели в осях по умолчанию js, возвращает x, y в формате формы пользователя
   * @param x
   * @param y
   * @returns {{x: number, y: number}}
   */
  getXYFromStandardAxes(x, y) {
    x -= this.w / 2;
    y = -(y - this.h / 2);
    return this.getXYFromNormalAxes(x, y);
  }

  getDx() {
    return 5;
  }

  getDy() {
    return 5;
  }
}
