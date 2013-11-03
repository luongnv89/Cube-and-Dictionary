
function MPI_Wtime()
  implicit none
  double precision :: MPI_Wtime, foo
  call MPI_Wtime_f90(foo)
  MPI_Wtime = foo
end function MPI_Wtime

