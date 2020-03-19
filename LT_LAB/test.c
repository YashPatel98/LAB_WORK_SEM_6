#include <stdio.h>
#include <math.h>
double getans(double x ,double y)
{
	double ans = pow(x,y);
	return ans;
}
int main()
{
	printf("%d",getans(2,3));
	return 0;
}
