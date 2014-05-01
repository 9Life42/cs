#include"collection.h"
#include<stdio.h>

int numbers[20] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                   11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

void init_collections(Collection, Collection, Collection);
void collection_fun(Collection, Collection, Collection);
void print_collection_array(void **, int );
void print_collection(Collection);
void empty_collection(Collection);

int main(void) {

  Collection evens;
  Collection odds;
  Collection all;   
 
  /// lets have some FUN with pointers!! 
  init_collections(all, evens, odds);
  collection_fun(all, evens, odds);
}

///--- the pointer party.. aka fun.
void collection_fun(Collection evens, Collection odds, Collection all) {

  int i;
  void **snapshot;

  /// just playin' around with the collections
  snapshot=collection_as_array(odds);
  collection_remove_at(odds, 9);
  collection_remove_at(odds, 3);
  printf("odds collection:\n");
  print_collection_array(snapshot, odds->size);
  empty_collection(evens);
  collection_add_item(evens, (void *)(numbers+6));
  puts("\n\nevens collection:");
  print_collection(evens);
  init_collections(all, evens, odds);
  puts("\n\nodds collection:");
  print_collection_array(snapshot, odds->size);
  puts("\n\nall collection:");
  print_collection(all);
}

//--empty_collection
// removes all elements from a collection
void empty_collection(Collection c) {
  if (c->size == 0) return;
  collection_remove_at(c,c->size);
  empty_collection(c);
}

////--- initializes the collections by adding the numbers data to each
void init_collections(Collection all, Collection evens, Collection odds) {

  int i;
  all=new_collection();
  evens=new_collection();

  for(i=0;i<20;i++) {
    collection_add_item(all, (void *)(numbers+i));
    if (numbers[i]%2) {
      collection_add_item(odds, (void *)(numbers+i));
    }else {
      collection_add_item(evens, (void *)(numbers+i));
    }  
  }
}


//--- prints the collection
void print_collection(Collection c) {

  void **arr = collection_as_array(c);
  print_collection_array(arr, c->size);
  free(arr);
}


// prints a snapshot of the collection
void print_collection_array(void **arr, int sz) {

  int i;
  for(i=0;i<sz;i++) {
    printf("%d\n", *((int *)arr[i]));
  }
}
