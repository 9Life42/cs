#include<stdlib.h>

#define COLLECTION_ERR_NULL -1
#define COLLECTION_MEM_ERR -2

typedef struct citem_t {
   void *object;
   struct citem_t *prev;
   struct citem_t *next;
} collection_item_t;

typedef struct collection_t {
  int size;
  collection_item_t *first;
  collection_item_t *last;
} *Collection;


Collection new_collection();
void destroy_collection(Collection);
int collection_add_item(Collection, void *);
void * collection_item_at(Collection, int);
void collection_remove_at(Collection, int);
void ** collection_as_array(Collection);
