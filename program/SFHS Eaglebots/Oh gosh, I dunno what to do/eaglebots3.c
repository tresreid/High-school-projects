/* 
This is a simple demonstration of the BRAIN unit.
Each input channel is mapped to a servo and and 
speed control output
*/

#include <msp430x14x.h>
#include <bestapi.h>
//void outputLeft(unsigned int linke, unsigned int recht);
//void outputRight(unsigned int debugX, unsigned int debugY);

int main( void )
{
  unsigned int left;
  unsigned int right;
  //unsigned int debugL;
  //unsigned int debugR;
  unsigned int IRemitter;
  unsigned int IRtoggle;
  signed int dump;
  //unsigned int toggledump;  <-- failed attempt
  //unsigned int dumpswitch;
  
  // short chan;
  // short inval;

  InitBrain();   /* initialize the system */
   
  // do this forever
  
  while(1)
  {
    // Drive Motors
    left = getRcValue(2, 50, 100);
    right = getRcValue(1, 50, 100);
    
    setMotor(0, left);
    setMotor(1, right);
  
    // Dump mechanism, works in theory
    dump = getRcValue(3, 50, 100);
    
    setServo(0,dump);
    setServo(1,-dump + 1024);
    
    //setMotor(2,dump - 1074);
    //setMotor(3,-dump + 562);
      
    // Infrared trasmitter, also works in theory
    IRemitter = getRcValue(0, 50, 100);
    
    if(IRemitter == 512)
      IRtoggle = 500;
    
    if(IRemitter <= 35)
      IRtoggle = IRtoggle - 100;
    
    if(IRemitter >= 989)
      IRtoggle = IRtoggle + 100;
    
    if(100 <= IRtoggle <= 900)
      if(IRtoggle != 500)
        
        setServo(2, IRtoggle);

    //debugL = getRcValue(1, 50, 120);
    //debugR = getRcValue(2, 50, 120);
    //outputRight(debugL, debugR);
    
    
  }
}
