
function MPI_Wtick()
  implicit none
  double precision :: MPI_Wtick, foo
  call MPI_Wtick_f90(foo)
  MPI_Wtick = foo
end function MPI_Wtick

