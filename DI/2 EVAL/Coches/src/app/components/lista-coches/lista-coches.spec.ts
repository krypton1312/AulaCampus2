import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaCoches } from './lista-coches';

describe('ListaCoches', () => {
  let component: ListaCoches;
  let fixture: ComponentFixture<ListaCoches>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaCoches]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListaCoches);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
