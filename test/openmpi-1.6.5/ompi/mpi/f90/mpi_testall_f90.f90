
subroutine MPI_TestallS(count, array_of_requests, flag, array_of_statuses, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: count
  integer, dimension(count), intent(inout) :: array_of_requests
  logical, intent(out) :: flag
  integer, dimension(MPI_STATUS_SIZE, count), intent(out) :: array_of_statuses
  integer, intent(out) :: ierr

  call MPI_Testall(count, array_of_requests, flag, array_of_statuses, ierr)
end subroutine MPI_TestallS


subroutine MPI_TestallI(count, array_of_requests, flag, array_of_statuses, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: count
  integer, dimension(count), intent(inout) :: array_of_requests
  logical, intent(out) :: flag
  double precision, intent(out) :: array_of_statuses
  integer, intent(out) :: ierr

  call MPI_Testall(count, array_of_requests, flag, array_of_statuses, ierr)
end subroutine MPI_TestallI

