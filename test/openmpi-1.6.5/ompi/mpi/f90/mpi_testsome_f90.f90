
subroutine MPI_TestsomeS(incount, array_of_requests, outcount, array_of_indices, array_of_statuses&
        , ierr)
  include 'mpif-config.h'
  integer, intent(in) :: incount
  integer, dimension(incount), intent(inout) :: array_of_requests
  integer, intent(out) :: outcount
  integer, dimension(*), intent(out) :: array_of_indices
  integer, dimension(MPI_STATUS_SIZE, incount), intent(out) :: array_of_statuses
  integer, intent(out) :: ierr

  call MPI_Testsome(incount, array_of_requests, outcount, array_of_indices, array_of_statuses, ierr)
end subroutine MPI_TestsomeS


subroutine MPI_TestsomeI(incount, array_of_requests, outcount, array_of_indices, array_of_statuses&
        , ierr)
  include 'mpif-config.h'
  integer, intent(in) :: incount
  integer, dimension(incount), intent(inout) :: array_of_requests
  integer, intent(out) :: outcount
  integer, dimension(*), intent(out) :: array_of_indices
  double precision, intent(out) :: array_of_statuses
  integer, intent(out) :: ierr

  call MPI_Testsome(incount, array_of_requests, outcount, array_of_indices, array_of_statuses, ierr)
end subroutine MPI_TestsomeI

