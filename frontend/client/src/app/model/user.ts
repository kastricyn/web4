export class User {
  private _login: string;

  constructor( login: string) {
    this._login = login;
  }

  get login(): string {
    return this._login;
  }

  set login(value: string) {
    this._login = value;
  }
}
