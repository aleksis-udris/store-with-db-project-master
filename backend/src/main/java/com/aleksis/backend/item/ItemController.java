package com.aleksis.backend.item;
import com.aleksis.backend.item.models.CreateCommand;
import com.aleksis.backend.item.models.Item;
import com.aleksis.backend.item.models.ItemDTO;
import com.aleksis.backend.item.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173/", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final GetItemsService getItemsService;
    private final GetItemService getItemService;
    private final AddItemService addItemService;
    private final DeleteItemService deleteItemService;
    private final EditItemService editItemService;

    public ItemController(GetItemsService getItemsService, AddItemService addItemService,
                          DeleteItemService deleteItemService, GetItemService getItemService,
                          EditItemService editItemService) {
        this.getItemsService = getItemsService;
        this.addItemService = addItemService;
        this.deleteItemService = deleteItemService;
        this.getItemService = getItemService;
        this.editItemService = editItemService;
    }

    @GetMapping("/")
    public ResponseEntity<List<ItemDTO>> getItems() {
        return getItemsService.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getItem(@PathVariable Integer id) {
        return getItemService.execute(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ItemDTO> createItem(@RequestBody Item inputItem) {
        return addItemService.execute(inputItem);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Integer id) {
        return deleteItemService.execute(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ItemDTO> editItem(@PathVariable Integer id, @RequestBody Item inputItem) { return editItemService.execute(new CreateCommand(id, inputItem));}
}
