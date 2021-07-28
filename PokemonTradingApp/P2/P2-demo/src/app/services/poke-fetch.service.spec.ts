import { TestBed } from '@angular/core/testing';

import { PokeFetchService } from './poke-fetch.service';

describe('PokeFetchService', () => {
  let service: PokeFetchService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PokeFetchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
