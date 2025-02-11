f0 lin 20 6    # Store 6 in register 20
f1 lin 21 1    # Store 1 in register 21 (for result)
f2 lin 22 1    # Store 1 in register 22 (loop decrement)
f3 mul 21 21 20  # Multiply register 21 by register 20 and store in 21
f4 sub 20 20 22  # Subtract 1 from register 20
f5 bnz 20 f3   # If register 20 is not zero, jump to f3 (loop)
f6 out 21      # Print the result (720)
