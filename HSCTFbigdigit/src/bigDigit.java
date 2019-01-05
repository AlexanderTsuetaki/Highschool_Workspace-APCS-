import java.util.ArrayList;
nDigitSum(n,p)    := sum((-1)^k*binomial(n,k)*binomial(n+p-10*k-1,n-1),k,0,floor(p/10));
	nDigitSumP(n,p)   := if(primep(p)) then nDigitSum(n,p) else 0;
	nPrimeDigitSum(n) := sum(nDigitSumP(n,p),p,2,9*n);
	result: nPrimeDigitSum(400)-nPrimeDigitSum(20);
	set_display('ascii);
	print(result)$
