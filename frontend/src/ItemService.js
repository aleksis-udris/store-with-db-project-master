import axios from "axios";

const API_BASE_URL = "http://localhost:8080/api/items"


class ItemService {
    getItems() {
        return axios.get(API_BASE_URL + "/");
    }

    getItem(id) {
        return axios.get(API_BASE_URL + '/' + id);
    }

    addItem(item) {
        return axios.post(API_BASE_URL + '/add', item);
    }

    deleteItem(id) {
        return axios.delete(API_BASE_URL + '/delete/' + id);
    }

    updateItem(item) {
        return axios.put(API_BASE_URL + '/edit/' + item.id, item)
    }
}

export default new ItemService();