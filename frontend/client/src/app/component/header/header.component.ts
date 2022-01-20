import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../service/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  get authService(): AuthService {
    return this._authService;
  }

  constructor(private _authService: AuthService) {
  }

  ngOnInit(): void {

  }

}
