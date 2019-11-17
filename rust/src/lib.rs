pub struct Board {
    data: Vec<bool>,
    cols: usize,
    rows: usize,
}

impl Board {
    pub fn create(rows: usize, cols: usize) -> Board {
        Board {
            cols,
	    rows,
            data: vec![false; rows * cols],
        }
    }

    pub fn set_alive(&mut self, row: usize, col: usize) {
        self.data[col + row * self.cols] = true;
    }

    pub fn evolve(self) -> Board {
        Board::create(10, 10)
    }

    pub fn neighbors(&self, row: usize, col: usize) -> usize {
        let index = |i, j| {
	    let col = col as isize + j;
	    let row = row  as isize + i;
	    if col < 0 || row < 0 || col >= (self.cols as isize) || row >= (self.rows as isize) {
		None
	    }
	    else {
		Some(col as usize  + (row  as usize) * self.cols)
	    }
	};
	
        let mut sum = 0;
        for i in -1..=1 {
            for j in -1..=1 {
                if i == 0 && j == 0 {
                    continue;
                }
		
		if let Some(ind) = index(i,j) {
                    match self.data.get(ind as usize) {
                    Some(true) => {
                        sum += 1;
                    }
                    _ => (),
                }

		}
	    }
        }
        sum
    }
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn create_board() {
        let mut b = Board::create(10, 10);
        assert_eq!(false, b.data[0]);
        b.set_alive(0, 0);
        assert_eq!(true, b.data[0]);
    }

    #[test]
    fn count_neighbor() {
        let b = {
            let mut b = Board::create(3, 3);
            b.set_alive(0, 0);
            b.set_alive(0, 2);
            b
        };
        assert_eq!(2, b.neighbors(1, 1));
    }

    #[test]
    fn count_neighbor2() {
        let b = {
            let mut b = Board::create(3, 3);
            b.set_alive(0, 0);
            b.set_alive(0, 2);
            b
        };
        assert_eq!(0, b.neighbors(0, 0));
    }
}
