struct DLinkedNode {
    int key, value;
    DLinkedNode* prev;
    DLinkedNode* next;
    DLinkedNode(): key(0), value(0), prev(nullptr), next(nullptr) {}
    DLinkedNode(int _key, int _value): key(_key), value(_value), prev(nullptr), next(nullptr) {}
};
/*
hash map存放key-DLinkedNode指针
双向链表节点存放key，value
双向链表头部是最新数据，尾部是LRU数据，超出容量时删除
空头结点和尾节点减少删除和添加节点时的相邻节点检查
*/
class LRUCache {
private:
    //hash map
    unordered_map<int, DLinkedNode*> map;
    DLinkedNode* head;
    DLinkedNode* tail;
    int size;
    int capacity;

public:
    LRUCache(int _capacity): capacity(_capacity),size(0) {
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head->next = tail;
        tail->prev = head;
    }
    
    int get(int key) {
        if(!map.count(key)){
            return -1;
        }
        //如果key存在，先通过map定位，再移到头部
        DLinkedNode* node = map[key];
        moveToHead(node);
        return node->value;
    }
    
    void put(int key, int value) {
        if(!map.count(key)){
            //如果key不存在，先创建节点，再加入map，并进行size检查，然后插入链表头部
            DLinkedNode* node = new DLinkedNode(key, value);
            map[key] = node;
            addToHead(node);
            ++size;
            if(size > capacity){
                //如果超出容量，则删除尾部节点，删除map中的项
                DLinkedNode* removed = removeTail();
                map.erase(removed->key);
                //防止内存泄漏
                delete removed;
                --size;
            }
        }
        else{
            //如果key存在，更新value，并移动到链表头部
            DLinkedNode* node = map[key];
            node->value = value;
            moveToHead(node);
        }
    }

    void addToHead(DLinkedNode* node){
        node->prev = head;
        node->next = head->next;
        head->next->prev = node;
        head->next = node;
    }
    DLinkedNode* removeTail(){
        DLinkedNode* node = tail->prev;
        removeNode(node);
        return node;
    }
    void removeNode(DLinkedNode* node){
        node->prev->next = node->next;
        node->next->prev = node->prev;
    }
    void moveToHead(DLinkedNode* node){
        removeNode(node);
        addToHead(node);
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */