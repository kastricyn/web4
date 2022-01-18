window.onload = setTimeout(draw, 50);
setInterval(draw, 250);

function draw() {
  const canvas = document.getElementById("areaCanvas");
  const h = canvas.height;
  const w = canvas.width;
  const c = canvas.getContext('2d');
  c.font = "14px Verdana";
  c.fillStyle = "white";
  c.fillRect(0, 0, w, h);
  c.fillStyle = "#359aff";
  drawArea(c, w, h);
  drawAxes(canvas, "black");
  drawAllPoint(w, h, c);
}

function drawAxes(canvas, color) {
  const h = canvas.height;
  const w = canvas.width;
  const c = canvas.getContext('2d');
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

function toNormalAxes(ctx, weight, height) {
  ctx.setTransform(1, 0, 0, 1, 0, 0); // устанавливаем значения по умолчанию
  ctx.translate(weight / 2, height / 2);
  ctx.scale(1, -1);
}

function drawArea(ctx, w, h, r) {
  r = 1;
  //Радиусы большого эллипса
  ctx.fillStyle = "#359aff";
  ctx.save();
  toNormalAxes(ctx, w, h);
  const corTransform = new CoordinateTransform(r, w, h);

  let {left: rPixel} = corTransform.getTopLeftInNormalAxes(r, r / 2)

  // console.log(rPixel, rPixel / 2);
  ctx.fillRect(0, 0, rPixel, rPixel / 2);
  //исуем треугольник
  ctx.beginPath();
  ctx.moveTo(0, 0);
  ctx.lineTo(rPixel, 0);
  ctx.lineTo(0, -rPixel / 2);
  ctx.closePath();
  ctx.fill();

  ctx.beginPath();
  ctx.moveTo(0, 0);
  ctx.arc(0, 0, rPixel / 2, -Math.PI / 2, -Math.PI, true);
  ctx.closePath();
  ctx.fill();

  ctx.restore();

}


function drawAllPoint(w, h, ctx) {
  const tr = $("#resultTable")[0].rows;
  for (const str of tr) {
    let [x, y, r, answ] = str.cells;
    drawPoint({
      w, h, ctx,
      x: parseFloat(x.innerText),
      y: parseFloat(y.innerText),
      r: parseFloat(r.innerText),
      color: "true" === answ.innerText ? "rgba(0, 255, 0, 0.6)" : "rgba(255, 0, 0, 0.6)",
    });
  }
}

function drawPoint({x, y, color, r, w, h, ctx}) {
  const corTransform = new CoordinateTransform(r, w, h)
  const {left, top} = corTransform.getTopLeftInStandardAxes(x, y);
  const [dx, dy] = [corTransform.getDx(), corTransform.getDy()];
  ctx.fillStyle = color;
  ctx.fillRect(left - dx / 2, top - dy / 2, dx, dy);
}
