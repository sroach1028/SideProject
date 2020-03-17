import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicnavComponent } from './publicnav.component';

describe('PublicnavComponent', () => {
  let component: PublicnavComponent;
  let fixture: ComponentFixture<PublicnavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PublicnavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PublicnavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
