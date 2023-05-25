import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatierePrefereeComponent } from './matiere-preferee.component';

describe('MatierePrefereeComponent', () => {
  let component: MatierePrefereeComponent;
  let fixture: ComponentFixture<MatierePrefereeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MatierePrefereeComponent]
    });
    fixture = TestBed.createComponent(MatierePrefereeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
