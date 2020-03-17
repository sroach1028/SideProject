export class Image {
  id: Number;
  url: string;
  title: string;
  description: string;

  constructor(
    id?: number,
    url?: string,
    title?: string,
    description?: string
    )
    {
      this.id = id;
      this.url = url;
      this.title = title;
      this.description = description;
    }
}
