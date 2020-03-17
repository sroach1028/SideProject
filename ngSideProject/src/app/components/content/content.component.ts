import { Image } from './../../models/image';
import { Component, OnInit } from '@angular/core';
import { ImageService } from 'src/app/services/image.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  images: Image[] = [];
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

}
