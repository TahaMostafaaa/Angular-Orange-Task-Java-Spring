import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListproductofcategoryComponent } from './listproductofcategory.component';

describe('ListproductofcategoryComponent', () => {
  let component: ListproductofcategoryComponent;
  let fixture: ComponentFixture<ListproductofcategoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListproductofcategoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListproductofcategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
