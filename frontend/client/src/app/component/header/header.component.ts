import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../service/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  user = {
    name: "Имя",
  }

  constructor(private authService: AuthService) {
  }

  isAuth = () :boolean => this.authService.authenticated


  ngOnInit(): void {
  }

}
