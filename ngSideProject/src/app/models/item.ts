export class Item {
  type: string;
  imageOne: String;
  imageTwo: String;
  imageThree: String;

  constructor(
    type?: string,
    imageOne?: string,
    imageTwo?: string,
    imageThree?: string
  )
  {
    this.type = type;
    this.imageOne = imageOne;
    this.imageTwo = imageTwo;
    this.imageThree = imageThree;
  }
}
