#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

struct node{
	char pid;
	int start;
	int size;
	struct node *next;
};
struct node *head;

void showMenu(){
	printf("\n\n1. Display LinkedList\n");
	printf("2. Best Fit\n");
	printf("3. Worst Fit\n");
	printf("4. First Fit\n");
	printf("5. Exit\n");
	printf("Enter Your choice : ");
}


void display(){
	printf("\n");
	struct node *ptr=head;
	while(ptr != NULL){
		printf("%c|%d|%d --> ", ptr->pid, ptr->start, ptr->size);
		ptr = ptr->next;
	}
	printf("NULL \n");
}

void bestFit(char pid, int size){
	int minDiff = INT_MAX;
	struct node *place;
	struct node *ptr=head;
	while(ptr!=NULL){
		if(ptr->pid=='Z'){
			int diff= ptr->size - size;
		
			if(diff<minDiff){
				minDiff = diff;	
				place = ptr;
			}
		}
		ptr = ptr->next;
	}
	if(minDiff<0){ printf("Process Can't allocated! [size exceded]\n"); return;}
	place->pid=pid;
	return;
}

void worstFit(char pid, int size){
	int minDiff = INT_MIN;
	struct node *place;
	struct node *ptr=head;
	while(ptr!=NULL){
		if(ptr->pid=='Z'){
			int diff= ptr->size - size;
			
			if(diff>minDiff){
				minDiff = diff;	
				place = ptr;
			}
		}
		ptr = ptr->next;
	}
	if(minDiff<0){ printf("Process Can't allocated! [size exceded]\n"); return;}
	place->pid=pid;
	return;
}

void firstFit(char pid, int size){
	struct node *ptr=head;
	int notAllocated=1;
	while(ptr!=NULL){
		if(ptr->pid=='Z' && size<ptr->size){
			ptr->pid=pid;
			notAllocated=0;
			break;
		}
		ptr = ptr->next;
	}
	if(notAllocated){ printf("Process Can't allocated! [size exceded]\n"); return;}
}

int main(){
	struct node n1,n2,n3,n4,n5,n6; 
	head=&n1;
	n1.pid='A'; n1.start=0; n1.size=4; n1.next=&n2;
	n2.pid='B'; n2.start=4; n2.size=3; n2.next=&n3;
	n3.pid='Z'; n3.start=7; n3.size=5; n3.next=&n4;
	n4.pid='D'; n4.start=12; n4.size=4; n4.next=&n5;
	n5.pid='Z'; n5.start=16; n5.size=3; n5.next=&n6;
	n6.pid='E'; n6.start=19; n6.size=4; n6.next=NULL;

	while(1){
		showMenu();
		int ch,size;
		char pid;
		scanf("%d", &ch);
		switch(ch){
			case 1: 	display(head);
						break;
						
			case 2: 	printf("Enter Process ID: ");
						scanf(" %c", &pid);			
						printf("Enter Process Size: ");
						scanf("%d", &size);
						bestFit(pid, size);
						break;
						
			case 3: 	printf("Enter Process ID: ");
						scanf(" %c", &pid);			
						printf("Enter Process Size: ");
						scanf("%d", &size);
						worstFit(pid, size);
						break;
						
			case 4: 	printf("Enter Process ID: ");
						scanf(" %c", &pid);			
						printf("Enter Process Size: ");
						scanf("%d", &size);
						firstFit(pid, size);
						break;
						
			case 5: 	exit(0);
		}
		display(head);
	}
	return 0;
}
