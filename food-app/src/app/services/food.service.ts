
import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Food } from '../models/food.model';

// map() function maps http responses onto objects
// import 'rxjs/Rx';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';

@Injectable()
export class FoodService {

  // inject Http object
  constructor(private http: Http) { }

  public fetchFoodInformation(id: number): Observable<Food> {
    return this.http.get(`https://pokeapi.co/api/v2/pokemon/${id}`).pipe(map((response: Response) => {
        return <Food> response.json();
      }));
  }

  private handleError(error: Response) {
    return Observable.throw(error.statusText);
  }

}
