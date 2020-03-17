import { Image } from './../models/image';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  private baseUrl = environment.baseUrl;
  newImage: Image = new Image;
  constructor(private http: HttpClient, private authSvc: AuthService) { }

  getAllImages() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    };
    return this.http.get<Image[]>(this.baseUrl + 'images', httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError('KABOOM');
        })
      );
  }

  postNewImage(image: Image) {
    return this.http.post<Image>(this.baseUrl + 'images', image)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('imageSvc.postNewImage(): error creating Image.');
      })
    );
  }

  removeImage(image: Image) {
    return this.http.delete(this.baseUrl + 'images/' + image.id)
    .pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('imageSvc.removeImage(): error removing Image.');
      })
    );
  }

}
