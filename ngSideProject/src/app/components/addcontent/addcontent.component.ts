import { NgForm } from '@angular/forms';
import { Image } from './../../models/image';
import { ImageService } from './../../services/image.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-addcontent',
  templateUrl: './addcontent.component.html',
  styleUrls: ['./addcontent.component.css']
})
export class AddcontentComponent implements OnInit {
  images: Image[] = [];
  url: string;
  newImage: Image;
  constructor(private imageSvc: ImageService) { }

  ngOnInit() {
    this.imageSvc.getAllImages().subscribe(
      goodStuff => {
        this.images = goodStuff;
      },

      badStuff => {
        console.error(badStuff);
      }
    );
  }

  postNewImage(form: NgForm) {
    this.newImage = form.value;
    this.imageSvc.postNewImage(this.newImage).subscribe(
      goodStuff => {
        this.ngOnInit();
      },

      badStuff => {
        console.error(badStuff);
      }
    );
  }
  removeImage(image: Image) {
    this.imageSvc.removeImage(image).subscribe(
      goodStuff => {
        this.ngOnInit();
      },

      badStuff => {
        console.error(badStuff);
      }
    );
  }


}
