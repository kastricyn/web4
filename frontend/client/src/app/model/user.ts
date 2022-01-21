export class User {
  private _id: string;
  private _login: string;

  constructor(id: string, name: string) {
    this._id = id;
    this._login = name;
  }


  get id(): string {
    return this._id;
  }

  get login(): string {
    return this._login;
  }
}
