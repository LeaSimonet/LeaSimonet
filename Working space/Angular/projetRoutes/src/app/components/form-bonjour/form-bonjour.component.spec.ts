import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormBonjourComponent } from './form-bonjour.component';

describe('FormBonjourComponent', () => {
  let component: FormBonjourComponent;
  let fixture: ComponentFixture<FormBonjourComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormBonjourComponent]
    });
    fixture = TestBed.createComponent(FormBonjourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
