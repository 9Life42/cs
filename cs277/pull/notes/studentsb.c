//----students.c -----------------------------------------------------------//
// reads a list of students from stdin, one name per line and adds them     //
//   to a student list                                                      //
//--------------------------------------------------------------------------//
#include "students.h"

//----- main
int main(void) {

  student *students=NULL;
  char *name;
  student *temp;

  while(read_line(name, MAX_NAME_LEN-1) > 0 && strcmp(name, FINISHED)) {
     temp = create_student(name);
     students = add_student(students, temp);
  }
  print_students(students);
  destroy_students(students);

  return 0;
}

//----------------------------- read_line ------------------------------//
/// reads a line from stdin and stores it in the provided buffer.       //
//   returns the length of the string or -1 on error or EOF             //
// [int] length read_line([char *] buffer)                              //
//----------------------------------------------------------------------//
int read_line(char *buf, int read_length) {

  size_t name_length;

  if (fgets(buf,read_length, stdin) == NULL) return -1;
  
  name_length=strlen(buf);
  if (buf[name_length-1]=='\n') {
    buf[name_length-1]='\0';
  }


  name_length=strlen(buf);
  if (name_length == 0) {
    return read_line(buf,read_length);
  } else{
    return name_length;
  }
}

//----------------------- create_student ----------------------------------//
// creates and initializes a student object.  returns a pointer to the new //
//  object.                                                                //
//  [student *] new_object create_student([char *] student_username)       //
//-------------------------------------------------------------------------//
student * create_student(char *nm) {

  student *my_student = (student *)malloc(sizeof(student));
  if (my_student == NULL) exit(-1);

  strcpy(my_student->username, nm);
  my_student->points;
  my_student->submissions;
  my_student->next;

  return my_student;
}

//--------------- add_student --------------------------------------------//
// adds a student object to the beginning of a linked list of student     //
//   objects, returns a pointer to the first student in the student list  //
// [student *] list_Start add_student([student *] list, [student *] new)  //
//------------------------------------------------------------------------//
student * add_student(student *students, student *new) {
  new->next=students->next;
  students->next=new;
  return students;
}

//--------------------------- print_students -----------------------------//
// iterates through the student list, printing the data for each student  //
//   to stdout                                                            //
// [void] print_students([student *] student_list)                        //
//------------------------------------------------------------------------//
void print_students(student *students) {
  while(students!=NULL) {
    printf("name:%s\npoints:%d\nsubmissions:%d\n\n", 
      students->username, students->points, students->submissions);
    students=students->next;
  }
}

//---------------------------- destroy_students -------------------------//
// iterates through the student list, releaseing any allocated memory    //
//  [void] destroy_students([student *] list)                            //
//-----------------------------------------------------------------------//
void destroy_students(student *list) {

  student *tofree;
  while(list != NULL) {
     tofree=list;
     list=list->next;
     free(tofree);
  }
}
