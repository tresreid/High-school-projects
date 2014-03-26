/* 
This is a simple demonstration of the BRAIN unit.
Each input channel is mapped to a servo and and 
speed control output
*/

#include <msp430x14x.h>
#include <bestapi.h>

int main( void )
{
  short chan;
  short inval;

  InitBrain();   /* initialize the system */
   
  // do this forever

  while(1)
  {
    // iterate over all the channels
    for(chan=0;chan!=4;chan++)
    {
      inval=getRcValue(chan,8,100);  // no gain, reasonable deadband

      // insert other processing with the input values
      
      // once you're done manipulating the input, send it out to 
      // the servo and/or speed controller - of course, you may
      // want to combine multiple channels of input to form your output
      // so, you'd need to change the loop structure to do that

      setServo(chan,inval);
      setMotor(chan,inval);
    }
  }
}
