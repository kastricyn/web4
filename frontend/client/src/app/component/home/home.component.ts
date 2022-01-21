import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {Router} from "@angular/router";
import {DrawContextService} from "../../service/draw-context.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  private drawer: DrawContextService | undefined

  constructor(private auth: AuthService, private router: Router) {

  }

  authenticated() {
    return this.auth.authenticated;
  }

  ngOnInit(): void {
    if (!this.authenticated())
      this.router.navigateByUrl('/login');
    this.drawer = new DrawContextService(<HTMLCanvasElement>document.getElementById("areaCanvas"))
    this.drawer.draw()
  }

}
