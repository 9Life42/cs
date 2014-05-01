#include"collection.h"

//--- new_collection
// allocates a new Collection object, returns pointer to object
Collection new_collection() {

  Collection newc = (struct collection_t *)malloc(sizeof(struct collection_t));
  newc->size=0;
  newc->first=newc->last=NULL;
  return newc;
}



//---destroy_collection
//  frees memory associated with the collection object, does not free
//  pointers to any array snapshots
void destroy_collection(Collection c) {

  collection_item_t *trav,*tofree;
  int i;

  if (c == NULL) return;
  trav=c->first;
  while(trav != NULL) {
    tofree=trav;
    trav=trav->next;
    free(tofree);
  }

  free(c);
}
 
//--add_item
//  adds an item to the collection, returns the size of the collection after
//   the addition
int collection_add_item(Collection c, void *obj) {

  if (c == NULL) return COLLECTION_ERR_NULL;

  collection_item_t *toAdd =
     (collection_item_t *)malloc(sizeof(collection_item_t));
  if (toAdd == NULL) return COLLECTION_MEM_ERR;
 
  // set first and last when empty
  if (c->size == 0) {
    c->first=toAdd;
    toAdd->prev=NULL;
  }else {
    toAdd->prev=c->last;
    c->last->next=toAdd;
    toAdd->next=NULL;
  }
 toAdd->object=obj;
 c->last=toAdd;
  
 return c->size++;
}

//----collection_item_at
//  returns a pointer to the object stored at location loc in the collection
void * collection_item_at(Collection c,int loc)  {

  int i;
  collection_item_t *trav;

  if (c == NULL || loc < 0 ) return NULL;
  trav=c->first;
  for(i=0;i<c->size;i++) {
    if (i == loc) {
      return trav->object;
    }
    trav=trav->next;
  }

  return NULL;
}

//---- collection_remove_at
// removes the item stored at location loc in the collection
void collection_remove_at(Collection c, int loc) {

  int i;
  collection_item_t *trav;

  if (c == NULL || loc < 0 || loc >= c->size) return;
  
  trav=c->first;
  for(i=0;i<c->size;i++) {
    if (i == loc) { 
        trav->prev->next=trav->next;
        trav->next->prev=trav->prev;
       
      // update dirst and last if needed
      if (loc == 0) {
        c->first=trav->next;
      }
      if (loc == c->size-1) {
        c->last=trav->prev;
      }
      free(trav);
      c->size--;
    }
    trav=trav->next;
  }
}


//-----collection_as_array
// takes a snapshot of the array and returns a pointer to it
void ** collection_as_array(Collection c) {

  void **r;
  collection_item_t *trav;
  int i;
 
  if (c==NULL || c->size == 0) return NULL;
  r=(void **)malloc(sizeof(void *) * c->size);
  if (r == NULL) return NULL;

  trav=c->first;
  for(i=0;i<c->size;i++) {
    r[i]=trav->object; 
    trav=trav->next;
  }

  return r;
 }

