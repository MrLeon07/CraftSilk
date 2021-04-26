package Inventories;

import java.util.HashMap;

import inventoryPages.AdminInventoryPage1;
import inventoryPages.AdminInventoryPage2;
import inventoryPages.AdminInventoryPage3;
import inventoryPages.AdminInventoryPage4;
import inventoryPages.AdminInventoryPage5;
import inventoryPages.AdminInventoryPage6;
import inventoryPages.IPage;

public class AdminItemsWindow {
	public HashMap<Integer,IPage> Pages = new HashMap<Integer,IPage>();
	public HashMap<String,Integer> PageNames = new HashMap<String,Integer>();
	public AdminItemsWindow() {
		Pages.put(1, new AdminInventoryPage1());
		Pages.put(2, new AdminInventoryPage2());
		Pages.put(3, new AdminInventoryPage3());
		Pages.put(4, new AdminInventoryPage4());
		Pages.put(5, new AdminInventoryPage5());
		Pages.put(6, new AdminInventoryPage6());
		PageNames.put(Pages.get(1).getPageName(), Pages.get(1).getPageNumber());
		PageNames.put(Pages.get(2).getPageName(), Pages.get(2).getPageNumber());
		PageNames.put(Pages.get(3).getPageName(), Pages.get(3).getPageNumber());
		PageNames.put(Pages.get(4).getPageName(), Pages.get(4).getPageNumber());
		PageNames.put(Pages.get(5).getPageName(), Pages.get(5).getPageNumber());
		PageNames.put(Pages.get(6).getPageName(), Pages.get(6).getPageNumber());
		
	
		
	}
}
