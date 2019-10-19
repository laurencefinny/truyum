import { TestBed } from '@angular/core/testing';

import { MenuItemServicesService } from './menu-item.service';

describe('MenuItemServicesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MenuItemServicesService = TestBed.get(MenuItemServicesService);
    expect(service).toBeTruthy();
  });
});
