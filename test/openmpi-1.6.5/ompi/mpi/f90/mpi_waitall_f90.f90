
subroutine MPI_WaitallS(count, array_of_requests, array_of_statuses, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: count
  integer, dimension(count), intent(inout) :: array_of_requests
  integer, dimension(MPI_STATUS_SIZE, count), intent(out) :: array_of_statuses
  integer, intent(out) :: ierr
  call MPI_Waitall(count, array_of_requests, array_of_statuses, ierr)
end subroutine MPI_WaitallS


subroutine MPI_WaitallI(count, array_of_requests, array_of_statuses, ierr)
  include 'mpif-config.h'
  integer, intent(in) :: count
  integer, dimension(count), intent(inout) :: array_of_requests
  double precision, intent(out) :: array_of_statuses
  integer, intent(out) :: ierr
  call MPI_Waitall(count, array_of_requests, array_of_statuses, ierr)
end subroutine MPI_WaitallI

