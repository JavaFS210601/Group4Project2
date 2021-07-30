import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokeBannerComponent } from './poke-banner.component';

describe('PokeBannerComponent', () => {
  let component: PokeBannerComponent;
  let fixture: ComponentFixture<PokeBannerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PokeBannerComponent]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PokeBannerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
