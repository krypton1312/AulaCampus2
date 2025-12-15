import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleCoche } from './detalle-coche';

describe('DetalleCoche', () => {
  let component: DetalleCoche;
  let fixture: ComponentFixture<DetalleCoche>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetalleCoche]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetalleCoche);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
