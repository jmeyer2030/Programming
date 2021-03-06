%Lets say that 0 is cherry, and 1 is lime
x = 0:1:200;
x=x';
data = generateH4; %generates sample, manually change for different graph
H1prob = probH1(x, data);
H2prob = probH2(x, data);
H3prob = probH3(x);%h3 doesn't need data because it doesn't matter whether the next is cherry or lime
H4prob = probH4(x, data);
H5prob = probH5(x, data);
sum = H1prob + H2prob + H3prob + H4prob + H5prob;
H1 = H1prob./sum;
H2 = H2prob./sum;
H3 = H3prob./sum;
H4 = H4prob./sum;
H5 = H5prob./sum;
PNextisLime = H1 .* 0+ H2 .* .25 + H3 .* .5 + H4 .* .75 + H5 .* 1.00;

%Graph Creation
plot(x, H1, x, H2, x, H3, x, H4, x, H5, x , PNextisLime)
title('Posterior Probability Generated as H4 with Probability That the Next Candy is Lime');
xlabel('number of observations in d');
ylabel('Posterior probability of hypothesis');
legend('H1','H2','H3','H4','H5', 'Probability that next is lime');




function [H3] = generateH3() %creates a randomly ordered array with 50% cherry and 50% lime
zero = zeros(1,100);
ones = zeros(1,100);
ones = ones + 1;
H3 = cat(1, zero, ones);
H3 = H3(randperm(200));
end

function [H4] = generateH4() %creates a randomly ordered array with 25% cherry and 75% lime
zero = zeros(1,200);
for c = 1:150
    zero(1,c) = 1;
end
H4 = zero;
H4 = H4(randperm(200));
end


%The five functions for probability are below:
function [H1vector] = probH1(x, data) 
H1innerProb = 1;
H1vector = zeros(201,1);
H1vector(1,1) = .1;
for c = 1:200 %for each data that we have seenP(d|hi) = prod(P(dj|hi))
    if data(1,c) == 1
        H1innerProb = 0;
    end
    H1innerProb = H1innerProb  * .5;
    H1vector(c+1,1)=H1innerProb*.1;
end
end
function [H2vector] = probH2(x, data) 
H2innerProb = 1;
H2vector = zeros(201,1);
H2vector(1)=.2;
for c = 1:200 %for each data that we have seenP(d|hi) = prod(P(dj|hi))
    if data(1,c) == 0
        H2innerProb = H2innerProb * .75;
    else
        H2innerProb = H2innerProb * .25;
    end
    H2vector(c+1) = H2innerProb * .2;
end
end
function [H3vector] = probH3(x) 
H3innerProb = 1;
H3vector = zeros(201,1);
H3vector(1)=.4;
for c = 1:200;
    H3innerProb = H3innerProb*.5;
    H3vector(c+1) = H3innerProb *.4;
end
end
function [H4vector] = probH4(x, data) 
H4innerProb = 1;
H4vector = zeros(201,1);
H4vector(1) = .2;
for c = 1:200 
    if data(1,c) == 0
        H4innerProb = H4innerProb * .25;
    else
        H4innerProb = H4innerProb * .75;
    end
    H4vector(c+1) = H4innerProb * .2;
end
end
function [H5vector] = probH5(x, data) 
H5innerProb = 1;
H5vector = zeros(201,1);
H5vector(1)=.1;
for c = 1:200 
    if data(1,c) == 0
        H5innerProb = 0;
    end
    H5innerProb=H5innerProb*.5;
    H5vector(c+1)=H5innerProb*.1;
end
end



